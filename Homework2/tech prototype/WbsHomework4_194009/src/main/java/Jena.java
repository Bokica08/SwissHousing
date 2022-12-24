import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

import java.util.List;

public class Jena {
    public static void main(String[] args) {
//        final String url1 = "https://dbpedia.org/resource/Lil_Uzi_Vert";
//        final Model model1 = ModelFactory.createDefaultModel();
//        model1.read(url1,"RDF/XML");
//       // model1.write(System.out,"TURTLE");
//        Resource uzi = model1.getResource("http://dbpedia.org/resource/Lil_Uzi_Vert");
//        System.out.println("+"+uzi+"+");
//        //model1.write(System.out,"TURTLE");
//        String property = "https://dbpedia.org/ontology/birthPlace";
//        Property p = model1.getProperty("https://dbpedia.org/ontology/birthPlace");
//        System.out.println(p.toString());
//
//        ResIterator resourceList = model1.listResourcesWithProperty(p);
//        Resource resource1 = null;
//        while (resourceList.hasNext()){
//            resource1=resourceList.nextResource();
//            System.out.println("123");
//        }
//        System.out.println("321");
//        if(resource1!=null) System.out.println(resource1);
//
//        StmtIterator stmtIterator = model1.listStatements(new SimpleSelector(uzi,p,(RDFNode) null));
//
//        while(stmtIterator.hasNext()){
//            System.out.println(stmtIterator.nextStatement().getSubject().toString());
//            //break;
//        }
//
//
//        final String url2 = "https://dbpedia.org/resource/Philadelphia";
//        final Model model2 = ModelFactory.createDefaultModel();
//        System.out.println("========================================================================================================================");
//        model2.read(url2,"RDF/XML");
//        Resource philly = model2.getResource(url2);
//        Property p2 = model2.getProperty("https://dbpedia.org/ontology/founder");
//        StmtIterator stmtIterator2 = model1.listStatements(new SimpleSelector(philly,p2,(RDFNode) null));
//
//        while(stmtIterator2.hasNext()){
//            System.out.println(stmtIterator.nextStatement().getSubject().toString());
//            break;
//        }
//
//        final String url3 ="https://dbpedia.org/resource/William_Penn";
//        final Model model3 = ModelFactory.createDefaultModel();
//        final String prop = "https://dbpedia.org/ontology/thumbnail";
//        model3.read("https://dbpedia.org/resource/William_Penn");
//        StmtIterator stmtIterator3 = model3.listStatements(new SimpleSelector(model3.getResource("https://dbpedia.org/page/William_Penn"),model3.getProperty("https://dbpedia.org/ontology/thumbnail"),(RDFNode) null));
//        while(stmtIterator3.hasNext()){
//            Statement s3 = stmtIterator3.nextStatement();
//            Resource s = s3.getSubject();
//            Property p = s3.getPredicate();
//            RDFNode o = s3.getObject();
//            System.out.println("SUBJECT: "+s.toString());
//            System.out.println("Predicate: "+p.toString());
//            if(o instanceof Object){
//                System.out.println("OBJECT: \""+o.toString()+"\"");
//            }else{
//                System.out.println(o.toString());
//            }
//            System.out.println(".\n");
//
//
//        }
        // model2.write(System.out,"TURTLE");
        //Resource name = (Resource) johnSmith.getProperty(VCARD.N).getObject();
        //Resource city = (Resource) model.getResource("https://dbpedia.org/ontology/Philadelphia");

        //System.out.println(city.toString());

        //Model model2 = ModelFactory.createDefaultModel();
        //model2.read("https://dbpedia.org/resource/Philadelphia");
        //model2.write(System.out);

        Model model4 = ModelFactory.createDefaultModel();
        model4.read("src/main/java/hifm-dataset-bio2rdf.ttl","TURTLE");
        //model4.write(System.out,"TURTLE");
        Property p = model4.getProperty("http://www.w3.org/2000/01/rdf-schema#seeAlso");
        Resource r = model4.getResource("http://purl.org/net/hifm/data#98175");
        StmtIterator iterator2 = model4.listStatements(new SimpleSelector(r, p,(RDFNode) null));
        while(iterator2.hasNext()){
            Statement s3 = iterator2.nextStatement();
            Resource s2 = s3.getSubject();
            Property p2 = s3.getPredicate();
            RDFNode o2 = s3.getObject();
            System.out.println("SUBJECT: "+s2.toString());
            System.out.println("Predicate: "+p.toString());
            if(o2 instanceof Object){
                System.out.println("OBJECT: \""+o2.toString()+"\"");
            }else{
                System.out.println(o2.toString());
            }
            System.out.println(".\n");


        }

    }
}

