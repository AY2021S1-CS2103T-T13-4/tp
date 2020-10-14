package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.account.Account;
import seedu.address.model.account.Name;
import seedu.address.model.account.entry.Description;
import seedu.address.testutil.TypicalEntries;

public class CommonCentsTest {

    private CommonCents commonCents = new CommonCents();

    @Test
    public void constructor() {
        assertEquals(new CommonCents(), commonCents);
    }

    @Test
    public void setAccounts() {
        Account account = TypicalEntries.getTypicalAccount();
        List<Account> accountList = Arrays.asList(account);
        commonCents.setAccounts(accountList);

        assertTrue(commonCents.hasAccount(account));
    }

    @Test
    public void resetData_nullData_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> commonCents.resetData(null));
    }

    @Test
    public void resetData_validData_returnsTrue() {
        CommonCents newData = TypicalEntries.getTypicalCommonCents();
        commonCents.setAccounts(newData.getAccountList());

        assertTrue(commonCents.hasAccount(newData.getAccountList().get(0)));
    }

    @Test
    public void hasAccount_accountNotInCommonCents_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> commonCents.hasAccount(null));
    }

    @Test
    public void hasAccount_accountNotInCommonCents_returnsFalse() {
        Account account = new Account(new Name("ALICE"));
        assertFalse(commonCents.hasAccount(account));
    }

    @Test
    public void hasAccount_accountInCommonCents_returnsTrue() {
        Account account = TypicalEntries.getTypicalAccount();
        assertTrue(commonCents.hasAccount(account));
    }

    @Test
    public void addAccount() {
        Account account = new Account(new Name("ALICE"));
        commonCents.addAccount(account);

        assertTrue(commonCents.hasAccount(account));
    }

    @Test
    public void setAccount_accountNotInCommonCents_returnsFalse() {
        Account target = new Account(new Name("ALICE"));
        Account edited = new Account(new Name("BEN"));

        assertFalse(commonCents.hasAccount(target));
    }

    @Test
    public void setAccount_validAccount_returnsTrue() {
        Account target = new Account(new Name("ALICE"));
        Account edited = new Account(new Name("BEN"));
        commonCents.addAccount(target);
        commonCents.setAccount(target, edited);

        assertTrue(commonCents.hasAccount(edited));
    }

    @Test
    public void setAccount_validEditedAccount() {
        Account edited = new Account(new Name("ALICE"));
        commonCents.addAccount(edited);
        edited.addExpense(TypicalEntries.getTypicalExpenses().get(0));
        commonCents.setAccount(edited);

        assertEquals(new Description("bought flower pots"), commonCents.getAccountList()
            .get(1).getExpenseList().get(0).getDescription());
    }

    @Test
    public void removeAccount_accountIsNotInCommonCents_returnsFalse() {
        Account account = new Account(new Name("ALICE"));
        assertFalse(commonCents.hasAccount(account));
    }

    @Test
    public void removeAccount_accountIsInCommonCents_returnsFalse() {
        Account account = new Account(new Name("ALICE"));
        commonCents.addAccount(account);
        commonCents.removeAccount(account);

        assertFalse(commonCents.hasAccount(account));
    }

}
