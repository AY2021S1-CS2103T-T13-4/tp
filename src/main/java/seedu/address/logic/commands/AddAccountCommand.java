package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.util.CliSyntax.PREFIX_NAME;

import seedu.address.model.Model;
import seedu.address.model.account.Account;
import seedu.address.model.account.ActiveAccount;

public class AddAccountCommand extends Command {
    public static final String COMMAND_WORD = "newacc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an Account to "
            + "Common Cents\n"
            + "Parameters: "
            + PREFIX_NAME + "ACCOUNT NAME ";

    public static final String MESSAGE_SUCCESS = "New account added! %1$s";

    public final Account account;

    /**
     * Creates an AddAccountCommand to add the specified {@code Account}
     */
    public AddAccountCommand(Account account) {
        requireNonNull(account);
        this.account = account;
    }

    @Override
    public CommandResult execute(Model model, ActiveAccount activeAccount) {
        requireNonNull(model);
        model.addAccount(this.account);
        return new CommandResult(String.format(MESSAGE_SUCCESS, this.account));

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddAccountCommand // instanceof handles nulls
                && account.equals(((AddAccountCommand) other).account));
    }

}
