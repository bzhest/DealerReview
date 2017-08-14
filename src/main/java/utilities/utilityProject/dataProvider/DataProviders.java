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
                {{"1","0.5",0.0,"1-st Title"}, {"1","1",0.0,"2-st Title"},{"1","1.5",0.5,"3-rd Title"},{"1","2",0.5,"4-th Title"},{"1","2.5",0.5,"5-th Title"},{"1","3",0.5,"6-th Title"},{"1","3.5",0.5,"7-th Title"},{"1","4",1.0,"8-th Title"},{"1","4.5",1.0,"9-th Title"},{"1","5",1.0,"10-th Title"}};
    }

    @DataProvider(name = "Set of stars for 2 parameters")
    public static Object[][] get2Parameters() {
        //{1,3 - Parameter Number, 2,4 - stars number in parameter, 5 - expected average number, 6 - review title}
        return new Object[][]
                {{"1","0.5", "2","0.5",0.0,"11-st Title"}, {"1","1",0.0,"2-st Title"},{"1","1.5",0.0,"3-rd Title"},{"1","2",0.0,"4-th Title"},{"1","2.5",0.0,"5-th Title"},{"1","3",0.5,"6-th Title"},{"1","3.5",0.5,"7-th Title"},{"1","4",0.5,"8-th Title"},{"1","4.5",0.5,"9-th Title"},{"1","5",1.0,"10-th Title"}};
    }
}
