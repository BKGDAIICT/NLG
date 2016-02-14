import java.util.ArrayList;

import simplenlg.aggregation.*;
import simplenlg.features.*;
import simplenlg.framework.*;
import simplenlg.phrasespec.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;


public class prephrase{
	String noun = new String();
	String prep = new String();
	private Lexicon lexicon = Lexicon.getDefaultLexicon();
    private NLGFactory nlgFactory = new NLGFactory(lexicon);
	//public prephrase(ArrayList<noun> noun,String prep)
	//{
	//	super(noun);
	//	this.prep = prep;
		
		
	//}
	public prephrase(String noun, String pre)
	{
		this.noun = noun;
		this.prep = pre;
		
	}
	
	public PPPhraseSpec getPrep()
	{
		PPPhraseSpec pp = nlgFactory.createPrepositionPhrase();
		pp.addComplement(noun);
		pp.setPreposition(prep);
  
    	return pp;
	}
	

	

}
