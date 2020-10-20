package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.CommonCents;
import seedu.address.model.ReadOnlyCommonCents;
import seedu.address.model.account.Account;
import seedu.address.model.account.Name;
import seedu.address.model.account.entry.Amount;
import seedu.address.model.account.entry.Description;
import seedu.address.model.account.entry.Expense;
import seedu.address.model.account.entry.ExpenseList;
import seedu.address.model.account.entry.Revenue;
import seedu.address.model.account.entry.RevenueList;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code CommonCents} with sample data.
 */
public class SampleCommonCentsUtilData {
    private static Account[] getSampleAccount() {
        Account acc = new Account(new Name("Lulu - bizacc"));
        RevenueList accRevenues = new RevenueList();
        accRevenues.add(new Revenue(new Description("earrings sales"),
                new Amount("13.50"), getTagSet("craft", "accessories")));
        accRevenues.add(new Revenue(new Description("phone cases sales"),
                new Amount("15.70"), getTagSet("phone", "accessories")));
        ExpenseList accExpenses = new ExpenseList();
        accExpenses
                .add(new Expense(new Description("Watercolours"),
                new Amount("12.10"), getTagSet("art", "colours")));
        accExpenses
                .add(new Expense(new Description("canvas"),
                new Amount("20.15"), getTagSet("art")));
        acc.setExpenses(accExpenses
        );
        acc.setRevenues(accRevenues);

        Account acc2 = new Account(new Name("Lulu - nonbiz acc"));
        ExpenseList acc2Expenses = new ExpenseList();
        RevenueList acc2Revenues = new RevenueList();
        acc2Expenses.add(new Expense(new Description("lunch"),
                new Amount("5.45"), getTagSet("food", "hawker")));
        acc2Expenses.add(new Expense(new Description("dinner at Morganfield's"),
                new Amount("24.45"), getTagSet("food", "restaurant", "Morganfields")));
        acc2.setExpenses(acc2Expenses);
        acc2.setRevenues(acc2Revenues);
        return new Account[]{acc, acc2};
    }

    public static ReadOnlyCommonCents getSampleCommonCents() {
        CommonCents sampleCc = new CommonCents();
        for (Account acc : getSampleAccount()) {
            sampleCc.addAccount(acc);
        }
        return sampleCc;
    }

    /**
     * Initializes a empty account.
     * @return A account with no entries.
     */
    private static Account initEmptyAccount() {
        Account acc = new Account(new Name("Default account"));
        return acc;
    }

    /**
     * Initializes a Common Cents with one default account.
     * @return A Common Cents with a default account with no entries.
     */
    public static ReadOnlyCommonCents initEmptyCommonCents() {
        CommonCents emptyCc = new CommonCents();
        emptyCc.addAccount(initEmptyAccount());
        return emptyCc;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
