package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.util.Category;
import seedu.address.model.Model;
import seedu.address.model.account.ActiveAccount;
import seedu.address.model.account.entry.Expense;
import seedu.address.model.account.entry.Revenue;


/**
 * Deletes an entry identified using it's displayed index from the revenue/expense list.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the Entry identified by the index number used in the displayed entry list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Entry: %1$s";

    private final Index targetIndex;
    private final Category category;

    public DeleteCommand(Index targetIndex, Category category) {
        this.targetIndex = targetIndex;
        this.category = category;
    }

    @Override
    public CommandResult execute(Model model, ActiveAccount activeAccount) throws CommandException {
        requireNonNull(model);

        ObservableList<Expense> expenseList = activeAccount.getFilteredExpenseList();
        ObservableList<Revenue> revenueList = activeAccount.getFilteredRevenueList();
        int index = targetIndex.getZeroBased();
        boolean isExpense = this.category.isExpense();
        boolean isRevenue = this.category.isRevenue();
        boolean isInvalidIndex = isExpense
                ? (index >= expenseList.size())
                : (index >= revenueList.size());

        if (isInvalidIndex) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        if (isExpense) {
            Expense toDelete = expenseList.get(index);
            activeAccount.deleteExpense(toDelete);
        } else if (isRevenue) {
            Revenue toDelete = revenueList.get(index);
            activeAccount.deleteRevenue(toDelete);
        }
        model.setAccount(activeAccount.getAccount());
        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, category));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    }
}
