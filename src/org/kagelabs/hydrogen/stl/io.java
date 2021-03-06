package org.kagelabs.hydrogen.stl;

import org.kagelabs.hydrogen.*;
import org.kagelabs.hydrogen.Error;

import java.util.HashMap;
import java.util.Scanner;

public class io {
        public ActionProvider getActionProvider() {
                class IOActionProvider implements ActionProvider {
                        HashMap<ActionMetadata, Action> actionMap;

                        IOActionProvider() {
                                actionMap = new HashMap<ActionMetadata, Action>();
                        }
    
                        public void init(ErrorHandler eh) {
                                class Print implements Action {
                                        ActionMetadata meta;
                                        Print() {
                                                meta = new ActionMetadata();
                                                meta.setName("print");
                                                meta.setNamespace("io");
                                                meta.setReturnPrefix('\0');
                                        }
                                        public ActionMetadata getMetadata() {
                                                return meta;
                                        }
                                        public void init(ErrorHandler eh) {
                                                // do nothing
                                        }
                                        public Value call(ErrorHandler eh, Value[] values) {
                                                for (int c = 0; c < values.length; c++) {
                                                        if (values[c].getType() == VarType.INVALID) {
                                                                eh.addError(new Error("Invalid print!", "The variable you are trying to print is invalid!", "io"));
                                                                continue;
                                                        }
                                                        System.out.println( ((values[c].getType() == VarType.NUMBER) ? values[c].getNumber() : values[c].getString()) );
                                                }
                                                return new Value(VarType.INVALID);
                                        }
                                }
                                Print print = new Print();
                                this.actionMap.put(print.getMetadata(), print);
                                
                                class Read implements Action {
                                    ActionMetadata meta;
                                    Read() {
                                            meta = new ActionMetadata();
                                            meta.setName("read");
                                            meta.setReturnPrefix('$');
                                            meta.setNamespace("io");
                                    }
                                    public ActionMetadata getMetadata() {
                                            return meta;
                                    }
                                    public void init(ErrorHandler eh) {
                                            // do nothing
                                    }
                                    public Value call(ErrorHandler eh, Value[] values) {
                                            // if there are arguments, system.out.print the first one
                                    		// scan system.in for strings
                                    		// return a string
                                    			Scanner kb = new Scanner(System.in);
                                    			if (values.length >= 1)
                                    			{
                                    				System.out.print(values[0].toString());
                                    			}
                                    			Value value = new Value(VarType.STRING);
                                    			value.setString(kb.nextLine());
                                    			
                                    			return value;
                                    }       
                                }
                        		
                                class Write implements Action {
                                    ActionMetadata meta;
                                    Write() {
                                            meta = new ActionMetadata();
                                            meta.setName("write");
                                            meta.setReturnPrefix('\0');
                                            meta.setNamespace("io");
                                    }
                                    public ActionMetadata getMetadata() {
                                            return meta;
                                    }
                                    public void init(ErrorHandler eh) {
                                            // do nothing
                                    }
                                    public Value call(ErrorHandler eh, Value[] values) {
                                            for (int c = 0; c < values.length; c++) {
                                                    if (values[c].getType() == VarType.INVALID) {
                                                            eh.addError(new Error("Invalid print!", "The variable you are trying to print is invalid!", "io"));
                                                            continue;
                                                    }
                                                    System.out.print( ((values[c].getType() == VarType.NUMBER) ? values[c].getNumber() : values[c].getString()) );
                                            }
                                            return new Value(VarType.INVALID);
                                    }
                            }
                            Write write = new Write();
                            this.actionMap.put(write.getMetadata(), write);
                                
                                Read read = new Read();
                                this.actionMap.put(read.getMetadata(), read);
                        }
    

                        public HashMap<ActionMetadata, Action> getActionDictionary() {
                                return this.actionMap;
                        }

						@Override
						public void run(ErrorHandler eh, ActionMetadata am) {
							// TODO Auto-generated method stub
						}
                }
                
                return new IOActionProvider();
        }
        public String getProviderName() {
        	return "IOActionProvider";
        }
        public String[] getActionNames() {
        	return new String[]{ "Print", "Read", "Write" };
        }
}
