package seedu.address.testutil;

import static seedu.address.logic.parser.util.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.util.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.util.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.util.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_ENTRY;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.model.account.entry.Entry;
import seedu.address.model.account.entry.Revenue;

/**
 * A utility class for Expense/Revenue.
 */
public class EntryUtil {
    public static final String EXPENSE_STRING = "expense";
    public static final String REVENUE_STRING = "revenue";

    /**
     * Returns an add command string for adding the {@code entry}.
     */
    public static String getAddCommand(Entry entry) {
        return AddCommand.COMMAND_WORD + " " + getEntryDetails(entry);
    }

    /**
     * Returns an delete command string for deleting first expense.
     */
    public static String getDeleteExpenseCommand() {
        return DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_ENTRY.getOneBased()
                + " " + PREFIX_CATEGORY + EXPENSE_STRING;
    }

    /**
     * Returns an delete command string for deleting first revenue.
     */
    public static String getDeleteRevenueCommand() {
        return DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_ENTRY.getOneBased()
                + " " + PREFIX_CATEGORY + REVENUE_STRING;
    }

    /**
     * Returns the part of command string for the given {@code entry}'s details.
     */
    public static String getEntryDetails(Entry entry) {
        StringBuilder sb = new StringBuilder();
        boolean isRevenue = entry instanceof Revenue;
        String category = isRevenue
                ? "revenue"
                : "expense";
        sb.append(PREFIX_CATEGORY + category + " ");
        sb.append(PREFIX_DESCRIPTION + entry.getDescription().toString() + " ");
        sb.append(PREFIX_AMOUNT + entry.getAmount().toString() + " ");
        entry.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }

}
