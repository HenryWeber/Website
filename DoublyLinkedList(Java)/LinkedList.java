
public class LinkedList {
	 
	 Node statehead;
	 Node stateend;
	 
	 Node countyhead;
	 Node countyend;
	 
	 Node pophead;
	 Node popend;
	 
	 Node mpophead;
	 Node mpopend;
	 
	 Node fpophead;
	 Node fpopend;
	 
	 Node povertyhead;
	 Node povertyend;
	 
	  
	  public void insert(String state, String county, int pop, int mpop, int fpop, int poverty)
	  {
	    Node node = new Node();
	    node.state = state;
	    node.county = county;
	    node.pop = pop;
	    node.mpop = mpop;
	    node.fpop = fpop;
	    node.poverty = poverty;
	    

	    Node header = statehead; 
	    if (header == null) {
	        statehead = node;
	        stateend = node;

	    } else if ( header.state.compareTo(node.state) > 0) {
	        node.nextstate = header;
	        header.laststate = node;
	        statehead = node;

	    } else {
	        Node nexter = statehead.nextstate;

	        while (nexter != null && nexter.state.compareTo(node.state) <= 0) {
	            header = nexter;
	            nexter = nexter.nextstate;
	        }
	        
	        header.nextstate = node;
	        node.laststate = header;
	        
	        if (nexter != null) {
	            nexter.laststate = node;
	            node.nextstate = nexter;
	        }
	        else if(nexter == null)
	        {
	        	stateend = node;
	        }
	    }
	    Node cheader = countyhead; 
	    if (cheader == null) {
	        countyhead = node;
	        countyend = node;

	    } else if ( cheader.county.compareTo(node.county) > 0) {
	        node.nextcounty = cheader;
	        cheader.lastcounty = node;
	        countyhead = node;

	    } else {
	        Node nexter = countyhead.nextcounty;

	        while (nexter != null && nexter.county.compareTo(node.county) <= 0) {
	            cheader = nexter;
	            nexter = nexter.nextcounty;
	        }

	        cheader.nextcounty = node;
	        node.lastcounty = cheader;

	        if (nexter != null) {
	            nexter.lastcounty = node;
	            node.nextcounty = nexter;
	        }
	        else if(nexter == null)
	        {
	        	countyend = node;
	        }
	    }
	    Node pheader = pophead; 
	    if (pheader == null) {
	        pophead = node;
	        popend = node;

	    } else if ( pheader.pop > node.pop) {
	        node.nextpop = pheader;
	        pheader.lastpop = node;
	        pophead = node;

	    } else {
	        Node nexter = pophead.nextpop;

	        while (nexter != null && nexter.pop <= node.pop) {
	            pheader = nexter;
	            nexter = nexter.nextpop;
	        }

	        pheader.nextpop = node;
	        node.lastpop = pheader;

	        if (nexter != null) {
	            nexter.lastpop = node;
	            node.nextpop = nexter;
	        }
	        else if(nexter == null)
	        {
	        	popend = node;
	        }
	    }
	    Node mheader = mpophead; 
	    if (mheader == null) {
	        mpophead = node;
	        mpopend = node;

	    } else if ( mheader.mpop > node.mpop) {
	        node.nextmpop = mheader;
	        mheader.lastmpop = node;
	        mpophead = node;

	    } else {
	        Node nexter = mpophead.nextmpop;

	        while (nexter != null && nexter.mpop <= node.mpop) {
	            mheader = nexter;
	            nexter = nexter.nextmpop;
	        }

	        mheader.nextmpop = node;
	        node.lastmpop = mheader;

	        if (nexter != null) {
	            nexter.lastmpop = node;
	            node.nextmpop = nexter;
	        }
	        else if(nexter == null)
	        {
	        	mpopend = node;
	        }
	    }
	    Node fheader = fpophead; 
	    if (fheader == null) {
	        fpophead = node;
	        fpopend = node;

	    } else if ( fheader.fpop > node.fpop) {
	        node.nextfpop = fheader;
	        fheader.lastfpop = node;
	        fpophead = node;

	    } else {
	        Node nexter = fpophead.nextfpop;

	        while (nexter != null && nexter.fpop <= node.fpop) {
	            fheader = nexter;
	            nexter = nexter.nextfpop;
	        }

	        fheader.nextfpop = node;
	        node.lastfpop = fheader;

	        if (nexter != null) {
	            nexter.lastfpop = node;
	            node.nextfpop = nexter;
	        }
	        else if(nexter == null)
	        {
	        	fpopend = node;
	        }
	    }
	    Node povheader = povertyhead; 
	    if (povheader == null) {
	        povertyhead = node;
	        povertyend = node;

	    } else if ( povheader.poverty > node.poverty) {
	        node.nextpoverty = povheader;
	        povheader.lastpoverty = node;
	        povertyhead = node;

	    } else {
	        Node nexter = povertyhead.nextpoverty;

	        while (nexter != null && nexter.poverty <= node.poverty) {
	            povheader = nexter;
	            nexter = nexter.nextpoverty;
	        }

	        povheader.nextpoverty = node;
	        node.lastpoverty = povheader;

	        if (nexter != null) {
	            nexter.lastpoverty = node;
	            node.nextpoverty = nexter;
	        }
	        else if(nexter == null)
	        {
	        	povertyend = node;
	        }
	    }
	  }
	  
	  public String show(String stringer)
	  {
		if(stringer == "State") 
		{
		    Node node=statehead;
		    String str = "";
		    while(node.nextstate!=null)
		    {
		      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		      node=node.nextstate;
		    }
		    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		    return str;
		}
		if(stringer == "County") 
		{
		    Node node=countyhead;
		    String str = "";
		    while(node.nextcounty!=null)
		    {
		      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		      node=node.nextcounty;
		    }
		    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		    return str;
		}
		if(stringer == "Pop.") 
		{
		    Node node=pophead;
		    String str = "";
		    while(node.nextpop!=null)
		    {
		      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		      node=node.nextpop;
		    }
		    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	"+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		    return str;
		}
		if(stringer == "Male Pop.") 
		{
		    Node node=mpophead;
		    String str = "";
		    while(node.nextmpop!=null)
		    {
		      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		      node=node.nextmpop;
		    }
		    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		    return str;
		}
		if(stringer == "Female Pop.") 
		{
		    Node node=fpophead;
		    String str = "";
		    while(node.nextfpop!=null)
		    {
		      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		      node=node.nextfpop;
		    }
		    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		    return str;
		}
		if(stringer == "Perc. under Pov.") 
		{
		    Node node=povertyhead;
		    String str = "";
		    while(node.nextpoverty!=null)
		    {
		      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		      node=node.nextpoverty;
		    }
		    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
		    return str;
		}
		else
			return"nah";
	  }
	  
	  public String showback(String stringer)
	  {
		  if(stringer == "State") 
			{
			    Node node=stateend;
			    String str = "";
			    while(node.laststate!=null)
			    {
			      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			      node=node.laststate;
			    }
			    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			    return str;
			}
			if(stringer == "County") 
			{
			    Node node=countyend;
			    String str = "";
			    while(node.lastcounty!=null)
			    {
			      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			      node=node.lastcounty;
			    }
			    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			    return str;
			}
			if(stringer == "Pop.") 
			{
			    Node node=popend;
			    String str = "";
			    while(node.lastpop!=null)
			    {
			      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			      node=node.lastpop;
			    }
			    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	"+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			    return str;
			}
			if(stringer == "Male Pop.") 
			{
			    Node node=mpopend;
			    String str = "";
			    while(node.lastmpop!=null)
			    {
			      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			      node=node.lastmpop;
			    }
			    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			    return str;
			}
			if(stringer == "Female Pop.") 
			{
			    Node node=fpopend;
			    String str = "";
			    while(node.lastfpop!=null)
			    {
			      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			      node=node.lastfpop;
			    }
			    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			    return str;
			}
			if(stringer == "Perc. under Pov.") 
			{
			    Node node=povertyend;
			    String str = "";
			    while(node.lastpoverty!=null)
			    {
			      str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			      node=node.lastpoverty;
			    }
			    str += node.state +"	"+ node.county +"	 "+ node.pop +"	 "+ node.mpop +"	 "+ node.fpop +"	 	"+ node.poverty+"%" + "\n";
			    return str;
			}
			else 
				return "nah";
	  }
	  
	  
	  
	}



