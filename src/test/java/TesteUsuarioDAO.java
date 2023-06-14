
import Controller.DAO.UsuarioDAO;
import Model.Usuario;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



public class TesteUsuarioDAO {

    JdbcDatabaseTester jdt;
    UsuarioDAO dao = new UsuarioDAO();
    
    @Before
    public void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException, Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        jdt.setDataSet(builder.build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/currentUsuario.xml")));
        jdt.onSetup();
    }
    
    @Test
    public void canInsertUser() throws SQLException, Exception {
        Usuario u = new Usuario();
        u.setLogin("guilherme");
        u.setEmail("guilherme@email.com");
        u.setNome("Guilherme Menezes");
        u.setSenha("SenhaDoGuilherme");
        
        dao.cadastraUsuario(u);
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        IDataSet expectedDataset = new FlatXmlDataSetBuilder().build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/expectedUsuario.xml"));
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void canAutenticateLogin() throws SQLException, Exception {
        String nomeUsuario = dao.autenticaLogin("joao", "JoaozinhoSenha");
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        
        Assert.assertEquals(nomeUsuario, currentTable.getValue(0, "nome"));
    }
    
    @Test
    public void canRecoveryLoginByName() throws SQLException, Exception {
        String loginUser = dao.recuperaUsuarioNome("Joao Pedro");
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        
        Assert.assertEquals(loginUser, currentTable.getValue(0, "login"));
    }
    
    @Test
    public void canRecoveryUserByLogin() throws SQLException, Exception {
        Usuario userExpected = new Usuario();
        userExpected.setLogin("joao");
        userExpected.setEmail("joao@email.com");
        userExpected.setNome("Joao Pedro");
        userExpected.setPontos(100);
        
        Usuario currentUser = dao.recuperaUsuarioLogin("joao");
        
        Assert.assertEquals(userExpected, currentUser);
    }
    
    @Test
    public void canListUserByRanking() throws SQLException, Exception {
        List<Usuario> lista = dao.listaUsuarios();
        assertEquals(2, lista.size());
        assertEquals("maria", lista.get(0).getLogin());
    }
}
