package seedu.guestnote.logic.commands;

<<<<<<< Updated upstream
=======
import static seedu.guestnote.model.Model.PREDICATE_SHOW_ALL_PERSONS;

>>>>>>> Stashed changes
import javafx.collections.ObservableList;
import seedu.guestnote.logic.commands.exceptions.CommandException;
import seedu.guestnote.model.Model;
import seedu.guestnote.model.guest.Guest;
import seedu.guestnote.model.guest.NameContainsKeywordsPredicate;

/**
 * Lists all guests in the guest book.
 * This command supports listing all guests as well as filtering the list based on a search query.
 * It utilizes the model's filtered person list to display the guests.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_EMPTY_GUEST_LIST = "No guests present";
    public static final String MESSAGE_NO_MATCHES = "No matching guests found.";
    public static final String MESSAGE_SUCCESS = "Listed all persons";

    private final NameContainsKeywordsPredicate predicate;

    public ListCommand() {
        this.predicate = null;
    }

    public ListCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the list command and returns the result.
     * If a search query is provided, the command filters the guest list by matching the guest's name or ID.
     * Otherwise, it displays all guests.
     * If the guest list is empty or no matching guests are found for a search query, a {@link CommandException}
     * is thrown.
     *
     * @param model The {@code Model} containing the guest book data.
     * @return A {@link CommandResult} containing the success message and the list of guests.
     * @throws CommandException If there are no guests present or no matching guests for the given query.
     */
    @Override
    public CommandResult execute(Model model) {
        // Update the filtered list to show all guests.
        if (predicate == null) {
            // Default behavior: list all guests
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        } else {
            // Search behavior: filter list based on the predicate
            model.updateFilteredPersonList(predicate);
        }

        ObservableList<Guest> guestList = model.getFilteredPersonList();

        // If the guest list is empty, throw an exception.
        if (guestList.isEmpty()) {
            return new CommandResult(MESSAGE_SUCCESS);
        }

        // Build the output string with each guest's room number and name.
        StringBuilder sb = new StringBuilder(MESSAGE_SUCCESS + "\n");
        for (Guest guest : guestList) {
            sb.append(String.format("Room Number: %s | Name: %s%n | UniqueID: %s \n\n",
                    guest.getRoomNumber(),
                    guest.getName(),
                    guest.getId()));
        }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
