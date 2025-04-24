package pages;

public class AllPages {

    private CLHomePage clHomePage;
    private CLSignupPage clSignupPage;
    private ContactListPage contactListPage;


    public CLHomePage getClHomePage() {
        if (clHomePage == null){
            clHomePage = new CLHomePage();
        }
        return clHomePage;
    }

    public CLSignupPage getClSignupPage() {
        if (clSignupPage ==null){
            clSignupPage = new CLSignupPage();
        }
        return clSignupPage;
    }

    public ContactListPage getContactListPage() {
        if (contactListPage == null){
            contactListPage = new ContactListPage();
        }
        return contactListPage;
    }
}
