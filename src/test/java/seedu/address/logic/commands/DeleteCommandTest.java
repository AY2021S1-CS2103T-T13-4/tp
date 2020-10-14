package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_TENTH_PERSON;
import static seedu.address.testutil.TypicalEntries.BUY_FLOWER_POTS;
import static seedu.address.testutil.TypicalEntries.SELL_FLOWER_POTS;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.category.Category;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.account.ActiveAccount;
import seedu.address.model.account.ActiveAccountManager;
import seedu.address.testutil.*;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 */
public class DeleteCommandTest {

    private final Model modelStub = new ModelStub();
    private final Category expense = new Category("expense");
    private final Category revenue = new Category("revenue");
    private final ActiveAccount activeAccountStub = new ActiveAccountStub();
    private final ActiveAccount activeAccount = new ActiveAccountManager(TypicalEntries.getTypicalAccount());

    @Test
    public void constructor_nullEntry_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeleteCommand(INDEX_FIRST_PERSON, expense).execute(modelStub, activeAccountStub));
    }

    @Test
    public void execute_validDeleteExpense_success() throws CommandException {
        CommandResult commandResult = new DeleteCommand(INDEX_FIRST_PERSON, expense).execute(modelStub, activeAccount);
        assertEquals(String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS, expense),
                commandResult.getFeedbackToUser());
        assertFalse(activeAccount.hasExpense(BUY_FLOWER_POTS));
    }

    @Test
    public void execute_validDeleteRevenue_success() throws CommandException {
        CommandResult commandResult = new DeleteCommand(INDEX_FIRST_PERSON, revenue).execute(modelStub, activeAccount);
        assertEquals(String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS, revenue),
                commandResult.getFeedbackToUser());
        assertFalse(activeAccount.hasRevenue(SELL_FLOWER_POTS));
    }

    @Test
    public void execute_validIndexExpense_Failure() {
        assertThrows(CommandException.class, () -> new DeleteCommand(INDEX_TENTH_PERSON, expense).execute(modelStub, activeAccount));
    }

    @Test
    public void execute_validIndexRevenue_Failure() {
        assertThrows(CommandException.class, () -> new DeleteCommand(INDEX_TENTH_PERSON, revenue).execute(modelStub, activeAccount));
    }

}
