import java.util.ArrayList;

public class testSingleLR {

	public static void main(String args[])
	{
		ArrayList<String> adj  = new ArrayList<String>();
		adj.add("5 star");
		adj.add("vegetarian");
		
		prephrase prephrase = new prephrase("railway station","near");
		prephrase prephrase1 = new prephrase("airport","near");
		ArrayList<prephrase> prephraseList  = new ArrayList<prephrase>();
		prephraseList.add(prephrase);
		ArrayList<prephrase> prephraseList1  = new ArrayList<prephrase>();
		prephraseList1.add(prephrase1);
		noun noun = new noun("restaurant",adj,null,"some");
		noun noun1 = new noun("hotels",null,prephraseList,null);
		ArrayList<noun> nounList  = new ArrayList<noun>();
		nounList.add(noun);
		nounList.add(noun1);
		
		
		
		
		
		
		
		//SingleLR sentence = new SingleLR("Here","be",nounList,prephraseList1);
		SingleLR sentence = new SingleLR("Here","be",nounList,null);
		String s = sentence.genSentence();
		System.out.print(s);
		
	}
}
