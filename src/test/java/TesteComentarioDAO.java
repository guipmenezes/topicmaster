
import Controller.DAO.ComentarioDAO;
import Model.Comentario;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import junit.framework.Assert;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



public class TesteComentarioDAO {

    JdbcDatabaseTester jdt;
    ComentarioDAO dao = new ComentarioDAO();
    
    @Before
    public void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException, Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        jdt.setDataSet(builder.build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/currentComentario.xml")));
        jdt.onSetup();
    }
    
    @Test
    public void canInsertCommentary() throws SQLException, Exception {
        String comentario = "comentario de numero 3";
        String login = "joao";
        int idTopico = 9;
        
        dao.inserirComentario(comentario, login, idTopico);
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("COMENTARIO");
        IDataSet expectedDataset = new FlatXmlDataSetBuilder().build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/expectedComentario.xml"));
        ITable expectedTable = expectedDataset.getTable("COMENTARIO");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void canSearchCommentsByPostId() throws SQLException, Exception {
        
        int idTopico = 9;
        
        List<Comentario> list = dao.buscarComentarioPorIdPost(idTopico);
        assertEquals(1, list.size());
        assertEquals("comentario de numero 2", list.get(0).getComentario());
    }  
    
}
