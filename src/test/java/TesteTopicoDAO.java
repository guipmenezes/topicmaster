
import Controller.DAO.TopicoDAO;
import Model.Topico;
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
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



public class TesteTopicoDAO {

    JdbcDatabaseTester jdt;
    TopicoDAO dao = new TopicoDAO();
    
    @Before
    public void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException, Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        jdt.setDataSet(builder.build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/currentTopico.xml")));
        jdt.onSetup();
    }
    
    @Test
    public void canReturnTopic() throws SQLException, Exception {
      List<Topico> list = dao.retornaTopico();
      assertEquals(2, list.size());
      assertEquals("titulo topico 1", list.get(0).getTitulo());
    }
    
    @Test
    public void canCreateTopic() throws SQLException, Exception {
        
        String titulo = "titulo topico 3";
        String conteudo = "conteudo topico 3";
        String login = "maria";
        
        dao.criaTopico(titulo, conteudo, login);
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("TOPICO");
        IDataSet expectedDataset = new FlatXmlDataSetBuilder().build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/expectedTopico.xml"));
        ITable expectedTable = expectedDataset.getTable("TOPICO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void canReturnTopicByTitle() throws SQLException, Exception {
        String titulo = "titulo topico 1";
        
        Topico expectedTopico = new Topico();
        expectedTopico.setTitulo(titulo);
        expectedTopico.setTexto("conteudo topico 1");
        expectedTopico.setLogin("joao");
        
        Topico currentTopico = dao.topicoPorTitulo(titulo);
        
        
        assertEquals(expectedTopico, currentTopico);
    }
}
