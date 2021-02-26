package pages;

public class CommonPage {
    public static final String XPATH_TEMPLATE_BUTTON = "//button[contains(text(), \"%s\")]";
    public static final String XPATH_TEMPLATE_INPUT_BOX = "//*[@placeholder='%s']";
    public static final String XPATH_TEMPLATE_TEXT = "//div[contains(text(), \"%s\")]";
    public static final String XPATH_TEMPLATE_DELETE_DASHBAORD_BUTTON = "//button[text()='%s']/parent::a/parent::div//div[@id='x']";
    public static final String XPATH_TEMPLATE_LINK = "//a/*[contains(text(),'%s')]";
    public static final String XPATH_TEMPLATE_SELECT = "//*[@id='%s']";
    public static final String XPATH_TEMPLATE_CELL = "//table//tbody//tr[%s]//td[%s]";
    public static final String XPATH_TEMPLATE_USER_BUTTON = "//td[contains(text(),'%s')]/parent::tr//button[text()='%s']";


//    public static void main(String[] args) {
//        String button = "Coding";
//        String xpath = String.format(XPATH_TEMPLATE_BUTTON, button);
//        System.out.println("=====> " + xpath);
//    }

}
