
import Controller.DAO.RankingDAO;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;



public class TesteRankingDAO {

    JdbcDatabaseTester jdt;
    RankingDAO dao = new RankingDAO();
    
    @Before
    public void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException, Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        jdt.setDataSet(builder.build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/currentUsuario.xml")));
        jdt.onSetup();
    }
    
    @Test
    public void canAddPointForCommentary() throws SQLException, Exception {
        
        dao.adicionaPontoComentario("joao");
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        IDataSet expectedDataset = new FlatXmlDataSetBuilder().build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/expectedRanking.xml"));
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void canAddPointForTopic() throws SQLException, Exception {
        
        dao.adicionaPontoTopico("joao");
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        IDataSet expectedDataset = new FlatXmlDataSetBuilder().build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/expectedRanking2.xml"));
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }  
    
}
