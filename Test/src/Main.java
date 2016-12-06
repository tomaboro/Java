import heart.*;
import heart.alsvfd.Formulae;
import heart.alsvfd.SimpleNumeric;
import heart.alsvfd.SimpleSymbolic;
import heart.alsvfd.Value;
import heart.alsvfd.expressions.ExpressionInterface;
import heart.exceptions.AttributeNotRegisteredException;
import heart.parser.hmr.HMRParser;
import heart.parser.hmr.runtime.SourceFile;
import heart.xtt.*;

import java.util.LinkedList;

/**
 * Created by Tomek on 05.12.2016.
 */
public class Main {
    public static void main(String[] args){
        try {
            //Loading a file with a model
            XTTModel model = null;
            SourceFile hmr_threat_monitor =
                    new SourceFile("C:\\JAVA\\Test\\threat-monitor.hmr.txt");
            HMRParser parser = new HMRParser();

            //Parsing the file with the model
            parser.parse(hmr_threat_monitor);
            model = parser.getModel();

            //Printing all the types within the model
            LinkedList<Type> types = model.getTypes();
            for(Type t : types){
                System.out.println("Type id: "+t.getId());
                System.out.println("Type name: "+t.getName());
                System.out.println("Type base: "+t.getBase());
                System.out.println("Type length: "+t.getLength());
                System.out.println("Type scale: "+t.getPrecision());
                System.out.println("desc: "+t.getDescription());

                for(Value v: t.getDomain().getValues()){
                    System.out.println("Value: "+v);
                }
                System.out.println("==========================");
            }

            //Printing all the attributes within the model
            LinkedList<Attribute> atts = model.getAttributes();
            for(Attribute att: atts){
                System.out.println("Att Id: "+att.getId());
                System.out.println("Att name: "+att.getName());
                System.out.println("Att typeName: "+att.getTypeId());
                System.out.println("Att abbrev: "+att.getAbbreviation());
                System.out.println("Att comm: "+att.getComm());
                System.out.println("Att desc: "+att.getDescription());
                System.out.println("Att class: "+att.getXTTClass());
                System.out.println("==========================");
            }

            //Printing all the tables and rules within the model
            LinkedList<Table> tables = model.getTables();
            for(Table t : tables){
                System.out.println("Table id:"+t.getId());
                System.out.println("Table name:"+t.getName());
                LinkedList<heart.xtt.Attribute> cond = t.getPrecondition();
                for(heart.xtt.Attribute a : cond){
                    System.out.println("schm Cond: "+a.getName());
                }
                LinkedList<heart.xtt.Attribute> concl = t.getConclusion();
                for(heart.xtt.Attribute a : concl){
                    System.out.println("schm Conclusion: "+a.getName());
                }

                System.out.println("RULES FOR TABLE "+t.getName());

                for(Rule r : t.getRules()){
                    System.out.print("Rule id: "+r.getId()+ ":\n\tIF ");
                    for(Formulae f : r.getConditions()){
                        System.out.print(f.getAttribute().getName()+" "+f.getOp()+" "+f.toString()+", ");
                    }

                    System.out.println("THEN ");

                    for(Decision d: r.getDecisions()){
                        System.out.print("\t"+d.getAttribute().getName()+"is set to ");

                        ExpressionInterface e = d.getDecision();
                        System.out.print(e);
                    }
                    System.out.println();

                }
                System.out.println();
                System.out.println("=============================");

                // Creating StateElements objects, one for each attribute
                StateElement hourE = new StateElement();
                StateElement dayE = new StateElement();
                StateElement locationE = new StateElement();
                StateElement activityE = new StateElement();

// Setting the values of the state elements
                hourE.setAttributeName("hour");
                hourE.setValue(new SimpleNumeric(16d));

                dayE.setAttributeName("day");
                dayE.setValue(new SimpleSymbolic("mon",1));

                locationE.setAttributeName("location");
                locationE.setValue(new SimpleSymbolic("work"));

                activityE.setAttributeName("activity");
                activityE.setValue(new SimpleSymbolic("walking"));


//Creating a XTTState object that agregates all the StateElements
                State XTTstate = new State();
                XTTstate.addStateElement(hourE);
                XTTstate.addStateElement(dayE);
                XTTstate.addStateElement(locationE);
                XTTstate.addStateElement(activityE);

// Printing current state (it should be null for all attributes,
// the state will be set later). The state can be set before inference
// by calling HeaRT.getWm().setCurrentState(...)
                System.out.println("Printing current state");
                State current = HeaRT.getWm().getCurrentState(model);
                for(StateElement se : current){
                    System.out.println("Attribute "+se.getAttributeName()+" = "+se.getValue());
                }

            }
            try{
// Fixed order inference -- we give all tables names
// in an order in which they should be fired
                HeaRT.fixedOrderInference(model,
                        new String[]{"DayTime","Today","Actions","Threats"},
                        new Configuration.Builder()
                                .setInitialState(XTTstate)
                                .build());

// Data driven inference -- we give only the starting tables names.
// The algorithm crawls the table network and fires only the necessary tables.
                HeaRT.dataDrivenInference(model,
                        new String[]{"DayTime","Today"},
                        new Configuration.Builder()
                                .setInitialState(XTTstate)
                                .build());

// Goal inference -- we only give the table which produces the attribute value
// that we are interested in.
// The algorithm crawls the table network and fires only the necessary tables.
                HeaRT.goalDrivenInference(model,
                        new String[]{"Threats"},
                        new Configuration.Builder()
                                .setInitialState(XTTstate)
                                .build());

            }catch(UnsupportedOperationException e){
                e.printStackTrace();
            } catch (AttributeNotRegisteredException e) {
                e.printStackTrace();
            }


            System.out.println("Printing current state (after inference");
            current = HeaRT.getWm().getCurrentState(model);
            for(StateElement se : current){
                System.out.println("Attribute "+se.getAttributeName()+" = "+se.getValue());
            }
        } catch (Exception allExceptions){
            // Simplified for the purpose of the example
        }
    }
}
