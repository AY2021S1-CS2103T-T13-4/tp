package seedu.address.testutil;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.account.Account;
import seedu.address.model.account.ActiveAccount;
import seedu.address.model.account.ReadOnlyAccount;
import seedu.address.model.account.entry.Entry;
import seedu.address.model.account.entry.Expense;
import seedu.address.model.account.entry.Revenue;


public class ActiveAccountStub implements ActiveAccount {
    @Override
    public void setActiveAccount(ReadOnlyAccount newActiveAccount) {

    }

    @Override
    public Account getAccount() {
        return null;
    }

    @Override
    public boolean hasEntry(Entry entry) {
        return false;
    }

    @Override
    public boolean hasExpense(Expense expense) {
        return false;
    }

    @Override
    public boolean hasRevenue(Revenue revenue) {
        return false;
    }

    @Override
    public void deleteExpense(Expense target) {

    }

    @Override
    public void deleteRevenue(Revenue target) {

    }

    @Override
    public void addExpense(Expense expense) {

    }

    @Override
    public void addRevenue(Revenue revenue) {

    }

    @Override
    public void setExpense(Expense target, Expense editedExpense) {

    }

    @Override
    public void setRevenue(Revenue target, Revenue editedRevenue) {

    }

    @Override
    public ObservableList<Expense> getFilteredExpenseList() {
        return null;
    }

    @Override
    public ObservableList<Revenue> getFilteredRevenueList() {
        return null;
    }


    @Override
    public void updateFilteredExpenseList(Predicate<Expense> predicate) {

    }

    @Override
    public void updateFilteredRevenueList(Predicate<Revenue> predicate) {

    }

}
