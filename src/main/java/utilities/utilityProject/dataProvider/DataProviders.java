package utilities.utilityProject.dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Created by DWork on 09.08.2017.
 */
public class DataProviders {


    @DataProvider(name = "Set of stars for 1 parameter")
    public static Object[][] get1Parameter() {
        //{1 - Parameter Number, 2 - stars number in parameter, 3 - expected average number, 4 - review title}
        return new Object[][]
                {{"1", "0.5", 0.0, "1-st Title"},
                        {"1", "1", 0.0, "2-st Title"},
                        {"1", "1.5", 0.5, "3-rd Title"},
                        {"1", "2", 0.5, "4-th Title"},
                        {"1", "2.5", 0.5, "5-th Title"},
                        {"1", "3", 0.5, "6-th Title"},
                        {"1", "3.5", 0.5, "7-th Title"},
                        {"1", "4", 1.0, "8-th Title"},
                        {"1", "4.5", 1.0, "9-th Title"},
                        {"1", "5", 1.0, "10-th Title"}};
    }

    @DataProvider(name = "Set of stars for 2 parameters")
    public static Object[][] get2Parameters() {
        //{1,3 - Parameter Number, 2,4 - stars number in parameter, 5 - expected average number, 6 - review title}
        return new Object[][]
                {{"1", "0.5", "2", "0.5", 0.0, "11-st Title"},
                        {"1", "1", "2", "1", 0.5, "12-st Title"},
                        {"1", "1.5", "2", "1.5", 0.5, "13-rd Title"},
                        {"1", "2", "2", "2", 1.0, "14-th Title"},
                        {"1", "2.5", "2", "2.5", 1.0, "15-th Title"},
                        {"1", "3", "2", "3", 1.0, "16-th Title"},
                        {"1", "3.5", "2", "3.5", 1.5, "17-th Title"},
                        {"1", "4", "2", "4", 1.5, "18-th Title"},
                        {"1", "4.5", "2", "4.5", 2.0, "19-th Title"},
                        {"1", "5", "2", "5", 2.0, "20-th Title"}};
    }

    @DataProvider(name = "Set of stars for 3 parameters")
    public static Object[][] get3Parameters() {
        return new Object[][]
                {{"2", "5", "4", "5", "1", "5", 3.0, "21-st Title"},
                        {"1", "5", "3", "5", "5", "5", 3.0, "22-st Title"},
                        {"1", "1", "2", "2", "3", "3", 1.0, "23-rd Title"},
                        {"1", "3", "4", "4", "5", "5", 2.5, "24-th Title"},
                        {"1", "0.5", "2", "0.5", "3", "0.5", 0.5, "25-th Title"},
                        {"1", "1", "3", "3", "5", "5", 2.0, "26-th Title"}};
    }
}
