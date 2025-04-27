package pages;

import org.apache.commons.lang3.AnnotationUtils;

public class AllPages {

    private CLLoginPage clLoginPage;
    private CLSignupPage clSignupPage;
    private CLHomePage CLHomePage;
    private ContactListPage contactListPage;
    private AddContactPage addContactPage;
    private ContactDetailsPage contactDetailsPage;
    private EditContactPage editContactPage;

    public CLLoginPage getclLoginPage() {
        if (clLoginPage == null) {
            clLoginPage = new CLLoginPage();
        }
        return clLoginPage;
    }

    public CLSignupPage getClSignupPage() {
        if (clSignupPage == null) {
            clSignupPage = new CLSignupPage();
        }
        return clSignupPage;
    }

    public CLHomePage getCLHomePage() {
        if (CLHomePage == null) {
            CLHomePage = new CLHomePage();
        }
        return CLHomePage;
    }

    public ContactListPage getContactListPage() {
        if (contactListPage == null) {
            contactListPage = new ContactListPage();
        }
        return contactListPage;
    }

    public AddContactPage getAddContactPage() {
        if (addContactPage == null) {
            addContactPage = new AddContactPage();
        }
        return addContactPage;
    }

    public ContactDetailsPage getContactDetailsPage() {
        if (contactDetailsPage == null) {
            contactDetailsPage = new ContactDetailsPage();
        }
        return contactDetailsPage;
    }

    public EditContactPage getEditContactPage() {
        if (editContactPage == null) {
            editContactPage = new EditContactPage();
        }
        return editContactPage;
    }
}
