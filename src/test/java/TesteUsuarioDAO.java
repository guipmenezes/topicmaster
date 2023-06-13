
import Controller.DAO.UsuarioDAO;
import Model.Usuario;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TesteUsuarioDAO {

    JdbcDatabaseTester jdt;
    UsuarioDAO dao = new UsuarioDAO();
    
    @Before
    public void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException, Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        jdt.setDataSet(builder.build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/dadosTeste.xml")));
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
        IDataSet expectedDataset = new FlatXmlDataSetBuilder().build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/verifica.xml"));
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void canLogin() throws SQLException, Exception {
        String nome = dao.autenticaLogin("joao", "JoaozinhoSenha");
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        
        Assert.assertEquals(nome, currentTable.getValue(0, "Joao Pedro"));
    }
}
