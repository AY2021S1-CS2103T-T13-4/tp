# User Guide

Common Cents is your convenient at-hand expense-tracking tool, meant for anyone who runs a small-scale business. With just a few commands, Common Cents will keep track, categorise and calculate your income and expenditure for you!

* Quick Start
* Features
  <!--* Viewing help: `help`-->
  * Adding an expense: `add`
  * Deleting an expense: `delete`
  * Editing an expense: `edit`
  * Finding expenses by a keyword: `find`
  * Exiting the program: `exit`
* Command Summary

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `commoncents.jar`.

1. Copy the file to the folder you want to use as the _home folder_ for CommonCents.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample expenses and income.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** 
and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`add c/expense d/buy lunch a/5.20 t/food`** : Adds an expense named "buy lunch" to the expense list.
   * **`delete 1 c/expense`** : Deletes the 1st entry in the expense list.
   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**Notes about the command format:**<br>

* Words in UPPERCASE are the parameters to be supplied by the user.<br>
  e.g. in `add C/CATEGORY...`, `CATEGORY` is a parameter which can be used as `add c/REVENUE...`

* Items in square brackets are optional.<br>
  e.g `...a/AMOUNT [t/TAG]` can be used as `...a/50.10 t/Supplies` or as `...a/50.10`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `c/CATEGORY d/DESCRIPTION...`, `d/DESCRIPTION c/CATEGORY...` is also acceptable.


</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding an entry: `add`

Adds an entry (expense/revenue) to the tracker.

Format: `add c/CATEGORY d/DESCRIPTION a/AMOUNT [t/TAG]`

* Adds an entry to either category.
* The category refers to the classification of the entry in the entry lists.
* The category must be either 'expense' or 'revenue'.

Examples:
* `add c/expense d/buying supplies a/10.10 t/blogshop t/eCommerce`
* `add c/revenue d/sale of clothes a/200 t/blogshop t/eCommerce`


### Deleting entries : `delete`

Removes an entry (expense/revenue) from the tracker.

Format: `delete ENTRY_INDEX c/CATEGORY`

* Deletes the entry at the specified INDEX.
* The index refers to the index number shown in the displayed entry lists.
* The index must be a positive integer 1, 2, 3, and must be within the range of the number of entries (e.g. if there are 10 entries, the INDEX given cannot be > 10)

Example:
* `delete 1 c/expense`
* `delete 2 c/revenue`


<!-- ### Editing an entry (expense/revenue) : `edit`

Edits an entry in the tracker.

* Edits an entry that matches the entry name and changes the parameters of an entry depending on which are specified
* The tags d/ and a/ have to be used to indicate which field specifies DESCRIPTION and which field specifies AMOUNT
* The index must be a positive integer 1, 2, 3, and must be within the range of the number of entries (e.g. if there are 10 entries, the `INDEX` given cannot be > 10)

Formats:
* `edit 1 c/CATEGORY d/DESCRIPTION a/AMOUNT t/TAG
   edit 2 c/CATEGORY d/DESCRIPTION
   edit 3 c/CATEGORY a/AMOUNT`

Example:
* `edit 2 c/expense n/buy McSpicy a/8.60` changes the name and the amount of entry 2 to `eating McSpicy` and `$8.60` respectively
* `edit 2 c/revenue n/sell McNuggets` changes the name of entry 2 to `sell McNuggets`
* `edit 2 c/expense a/5.50` changes the amount of entry 2 to `$5.50`


### Locating expenses by name: `find`

Find expenses that have the given keyword in their names.

* The search is case-sensitive. e.g `grocery` will match `grocery` but not `Grocery`.
* Only the expense name is searched.
* Expenses matching at least one keyword will be returned (i.e. OR search). e.g. `Food` will return `Hawker Food`, `Restaurant Food`

Format:
* `find KEYWORD [MORE_KEYWORDS]`

Example:
* `find food`: Finds expenses with the keyword `food`.
-->

### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help`
**Add** | `add c/CATEGORY d/DESCRIPTION a/AMOUNT [t/TAG]`
**Delete** | `delete ENTRY_INDEX c/CATEGORY`
**Exit** | `exit`

<!-- **Edit** | `edit ENTRY_NUM n/EXPENSE_NAME a/MONEY_AMT` -->
<!-- **Find** | `find KEYWORD [MORE_KEYWORDS]` -->