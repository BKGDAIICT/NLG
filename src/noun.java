import java.util.ArrayList;

import simplenlg.aggregation.*;
import simplenlg.features.*;
import simplenlg.framework.*;
import simplenlg.phrasespec.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
public class noun {

	
	private Lexicon lexicon = Lexicon.getDefaultLexicon();
    private NLGFactory nlgFactory = new NLGFactory(lexicon);
	// that clause missing
	String n = new String();
	ArrayList<String> adj = new ArrayList<String>(); // all the adjectives associated with the noun
	ArrayList<prephrase> prephrase = new ArrayList<prephrase>(); // all the preposition phrases associated 
	String det= new String(); // determiner
	//boolean type=false; // part of subject object or preposition phrase
	
	
	
	public noun(String noun,ArrayList<String> adj,ArrayList<prephrase> prephrase,String det)
	{
		this.n = noun;
		this.adj = adj;
		this.prephrase = prephrase;
		this.det = det;
		//this.type = type;
		
		
	}
	
	
	public NPPhraseSpec getNounPhrase()
	{	
		
		NPPhraseSpec noun = nlgFactory.createNounPhrase(n);
		noun.setDeterminer(det);
		
		
		if(adj!=null){
		for(String adj1: adj)
		{
			
			noun.addPreModifier(adj1);
		}
		}
		
	
		
		if(prephrase!=null){
		for(prephrase pre1: prephrase)
		{	
			PPPhraseSpec pp = nlgFactory.createPrepositionPhrase();
			pp = pre1.getPrep();
			noun.addComplement(pp);
			
			
		}
		}
		
		
		
		return noun;
	}
	
	
	
	
}
