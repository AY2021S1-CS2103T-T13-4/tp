package seedu.address.logic.commands;

import seedu.address.commons.core.category.Category;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.account.ActiveAccount;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.util.CliSyntax.PREFIX_CATEGORY;

/**
 * Clears all entries in the specified revenue/expense list of the account.
 */
public class ClearCommand extends Command {
    public static final String COMMAND_WORD = "clear";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Clears all entries in the specified entry (expense/revenue) list.\n"
            + "Parameters: c/CATEGORY\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_CATEGORY + "revenue";

    public static final String MESSAGE_DELETE_ENTRY_SUCCESS = "Cleared: %1$s" + "s";

    private final Category category;

    /**
     * Creates an ClearCommand to add the specified {@code Entry}
     */
    public ClearCommand(Category category) {
        this.category = category;
    }

    @Override
    public CommandResult execute(Model model, ActiveAccount activeAccount) throws CommandException {
        requireNonNull(model);

        boolean isExpense = this.category.isExpense();
        boolean isRevenue = this.category.isRevenue();

        if (isExpense) {
            activeAccount.clearExpenses();
        } else if (isRevenue) {
            activeAccount.clearRevenues();
        }
        model.setAccount(activeAccount.getAccount());
        return new CommandResult(String.format(MESSAGE_DELETE_ENTRY_SUCCESS, category));
    }

}
