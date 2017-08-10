package utilities.utilityProject.dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Created by DWork on 09.08.2017.
 */
public class DataProviders {
    @DataProvider(name = "set of stars")
    public static Object[][] getColor() {
        //{1 - Parameter Number, 2 - stars number in parameter, 3 - expected average number}
        return new Object[][]
                {{"1","0.5","0"}, {"1","1","0"},{"1","1.5","0.5"},{"1","2","0.5"},{"1","2.5","0.5"},{"1","3","0.5"},{1,3.5,0.5},{1,4,1},{1,4.5,1},{1,5,1}};
    }
}