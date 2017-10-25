import java.util.*;

public class SymTable{


	Vector<Vector<String>> table;

	public SymTable(){
		table = new Vector<Vector<String>>();
	}

	public void createNewBlock(){
		// insert to the end of vector
		Vector<String> block = new Vector<String>();
		table.add(block);
	}

	public void destroyCurrentBlock(){
		//remove from the end
		table.remove(table.size()-1);
	}

	public void addVariable(String variable){
		/* Added: check the current block of the table to prevent redeclaration */
        if( this.containInCurrent(variable) ){
            System.err.println("redeclaration of variable " + variable);
        } else {
			table.get(table.size()-1).add(variable);
		}
	}

	public void ensureDeclared(String variable, int linenum, int level, int isGlobal){
		// check the entire symbol table to make sure
		// the referenced variable is declared some where

		if(level >= table.size()){

			System.err.println("no such variable ~" + level + variable + " on line " + linenum);
			System.exit(1);

		} else if (isGlobal != 1 && level == -1) {
			
			if ( !containInAll(variable) ) {
				System.err.println(variable + " is an undeclared variable on line " + linenum);
				System.exit(1);
			}
		
		} else {

			if (isGlobal == 1) {
				if(!containIn(variable, table.size()-1)){
					System.err.println("no such variable ~" + variable + " on line " + linenum);
					System.exit(1);
				}
			} else {
				if( !containIn(variable, level) ){
					System.err.println("no such variable ~" + level + variable + " on line " + linenum);
					System.exit(1);
				}
			}

		}
	}

	public boolean containIn(String variable, int level){
		return table.get(table.size()-1-level).contains(variable);
	}

	public boolean containInCurrent(String variable){
		return table.get(table.size()-1).contains(variable);
	}

	public boolean containInAll(String variable){
		for (int i = 0; i < table.size() ; i++) {
			if( table.get(i).contains(variable) ){
				return true;
			}
		}

		return false;
	}

}
/*
     * A new block need to be added only when we enter a block()

	 * for id followed by @ sign, we know we are declaring id.
	 * Check in the SymTable for whether the table consists of
	 * the variable. 
	 	* if it already consists of the variable,
	 	* give appropriate error message, and continue

	 	* if it does not contain, insert the variable into
	 	* the current block

	 * if it reference_id, which means does not precede by the @ sign
	 * then we check the table again to ensure the variable has been
	 * declared


	 * Possible Errors
	 	* undeclared error
	 		* whole table is checked to make sure the variable is there

	 	* declared but not in scope
	 		* if there is NUM after '~'
	 			* specify the exact scoping level in which to find 
	 			* the given variable

	 		* no NUM means global variable
	 			* which can live thoughout the entire program
	 	* redeclaration
	 		* if the variable exist in the current block, it is redeclared
	 		* otherwise, it is not

*/





