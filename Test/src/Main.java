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
                    new SourceFile("C:\\Studia\\Java\\Test\\threat-monitor.hmr.txt");
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
                        System.out.print(f.getAttribute().getName()+" "+f.getOp()+" ");
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


            }

        } catch (Exception allExceptions){
            // Simplified for the purpose of the example
        }
    }
}
