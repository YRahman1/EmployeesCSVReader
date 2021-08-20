import com.sparta.yr.csvreader.FileIO;
import com.sparta.yr.dao.UserDAO;
import com.sparta.yr.dto.EmployeesDTO;
import com.sparta.yr.jdbc.ConnectionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class tests
{
    FileIO fileIO = new FileIO();
    UserDAO userDAO = new UserDAO(ConnectionManager.connectToDB());
    @Test
    void checkIfFileInputIsNotNull()
    {
        Assertions.assertNotNull(fileIO.getEmployeeList());
    }

    @Test
    void checkIfDataIsClean()
    {
        //Testing to see if duplicates remain after clean
        //Made for small database.
        ArrayList<EmployeesDTO> uncleanRecords = fileIO.getEmployeeList();
        ArrayList<EmployeesDTO> cleanRecords = fileIO.getDistinctList(uncleanRecords);
        Assertions.assertEquals(uncleanRecords.toArray().length,cleanRecords.toArray().length);
    }

    @Test
    void canDBBeTruncated()
    {
        //Tests to see if data is truncated( deleted) or not after truncate table is called.
        int currentRecs = userDAO.getNumberOfRecsPresent();
        userDAO.truncateTable();
        Assertions.assertEquals(userDAO.getNumberOfRecsPresent(),currentRecs);
    }

    @Test
    void checkIfRecIsInserted()
    {
        //Tests to see if data is truncated( deleted) or not after truncate table is called.
        int currentRecs = userDAO.getNumberOfRecsPresent();
        ArrayList<EmployeesDTO> uncleanRecords = fileIO.getEmployeeList();
        ArrayList<EmployeesDTO> cleanRecords = fileIO.getDistinctList(uncleanRecords);
        userDAO.createRecord(cleanRecords);
        Assertions.assertEquals(userDAO.getNumberOfRecsPresent(),currentRecs);
    }

}
