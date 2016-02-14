import java.util.ArrayList;

import simplenlg.aggregation.*;
import simplenlg.features.*;
import simplenlg.framework.*;
import simplenlg.phrasespec.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;

public class SingleLR {

	private Lexicon lexicon = Lexicon.getDefaultLexicon();
    private NLGFactory nlgFactory = new NLGFactory(lexicon);
    private Realiser realiser = new Realiser(lexicon);
    
    SPhraseSpec sentence = nlgFactory.createClause();
    
    
    private ArrayList<noun> nounList = new ArrayList<noun>();
	private ArrayList<prephrase> sprephrase = new ArrayList<prephrase>();
	private String sverb="be";
	private String sadverb="here";
	
	
	
	public SingleLR(String adverb,String verb, ArrayList<noun> nounList, ArrayList<prephrase> prephrase)
	{
		this.sverb=verb;
		this.sadverb=adverb;
		this.nounList=nounList;
		this.sprephrase= prephrase;
	}
	
	public String genSentence()
	{
		VPPhraseSpec verb = nlgFactory.createVerbPhrase(sverb);
    	sentence.setVerb(verb);
    	
    	
    	AdvPhraseSpec adverb = nlgFactory.createAdverbPhrase(sadverb);
    	sentence.setSubject(adverb);

    	ArrayList<NPPhraseSpec> nounspecList = new ArrayList<NPPhraseSpec>();
    	ArrayList<AdjPhraseSpec> adjList = new ArrayList<AdjPhraseSpec>();
    	ArrayList<PPPhraseSpec> prepList = new ArrayList<PPPhraseSpec>();
    	int i = 0;
    	for(noun n: nounList)
    	{
    		NPPhraseSpec nountemp = n.getNounPhrase();
    		if(n.adj != null){
    			adjList = n.getAdjphrase();
    		}
    		for(AdjPhraseSpec adj: adjList)
    		{
    			nountemp.addPreModifier(adj);	
    		}
    		
    		prepList = n.getPrephrase();
    		for(PPPhraseSpec prep: prepList)
    		{
    			nountemp.addComplement(prep);
    			
    		}
    		
    		
    		nounspecList.add(nountemp);
    		System.out.println(i);
    		i++;
    	}
    	
    	//nounphrase noun = new nounphrase(nounspecList);
    	
    	
    	CoordinatedPhraseElement object = nlgFactory.createCoordinatedPhrase();
    	for(NPPhraseSpec nps: nounspecList)
    	{
    		object.addComplement(nps);
    	}
    	
    	//object = noun.getcoordinatePhrase(); 
    	
    	sentence.setObject(object);
    	
    	
    	for(prephrase prep1: sprephrase)
    	{
    		PPPhraseSpec pp = nlgFactory.createPrepositionPhrase();
    		pp = prep1.getPrep();
    		sentence.addComplement(pp);	
    	}
    	
    	String output = realiser.realiseSentence(sentence);
 		System.out.println(output);
    	return output;
    
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
