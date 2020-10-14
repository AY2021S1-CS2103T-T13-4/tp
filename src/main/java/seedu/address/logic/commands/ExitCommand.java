package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.account.ActiveAccount;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Common Cents as requested ...";

    @Override
    public CommandResult execute(Model model, ActiveAccount activeAccount) {
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true);
    }

}
