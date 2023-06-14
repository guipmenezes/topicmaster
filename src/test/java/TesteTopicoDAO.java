
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



public class TesteTopicoDAO {

    JdbcDatabaseTester jdt;
    TesteTopicoDAO dao = new TesteTopicoDAO();
    
    @Before
    public void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException, Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        jdt.setDataSet(builder.build(new File("C:/Users/urlas/Documents/pasta-de-programacao/Projetos - ITA/projeto-topic-master/TopicMaster/src/test/java/currentTopico.xml")));
        jdt.onSetup();
    }
    
    @Test
    public void canReturnTopic() throws SQLException, Exception {
      
    }
}
