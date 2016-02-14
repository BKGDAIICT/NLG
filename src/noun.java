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
		
		return noun;
	}
	
	public ArrayList<AdjPhraseSpec> getAdjphrase()
	{	
		ArrayList<AdjPhraseSpec> adjList = new ArrayList<AdjPhraseSpec>();
		for(String adj1: adj)
		{
			//System.out.println(adj1);
				AdjPhraseSpec tempadj = nlgFactory.createAdjectivePhrase(adj1);
				adjList.add(tempadj);
		}
		return adjList;
		
	}
	
	public ArrayList<PPPhraseSpec> getPrephrase()
	{
		ArrayList<PPPhraseSpec> prepList = new ArrayList<PPPhraseSpec>();
		
		for(prephrase pre1: prephrase)
		{	
			PPPhraseSpec pp = nlgFactory.createPrepositionPhrase();
			pp = pre1.getPrep();
			prepList.add(pp);
			
		}
		
		return prepList;
	}
	
	
}
