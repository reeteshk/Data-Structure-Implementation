import java.util.List;
import java.util.ArrayList;

class DisjointSet{

    List<Integer> rank = new ArrayList<Integer>();
    List<Integer> parent = new ArrayList<Integer>();
    List<Integer> size = new ArrayList<Integer>();
    public DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node)
    {
        if(node == parent.get(node))
        {
            return node;
        }
        int ulp = findUPar(parent.get(node));//Path Compression is done in this case
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void UnionByRank(int u,int v)
    {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u))
        {
            parent.set(ulp_v,ulp_u);
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
     public void UnionBySize(int u,int v)
    {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            int sizeU = size.get(ulp_u);
            int sizeV = size.get(ulp_v);
            size.set(ulp_v,sizeU+sizeV);

        }
        else
        {
            parent.set(ulp_v,ulp_u);
            int sizeU = size.get(ulp_u);
            int sizeV = size.get(ulp_v);
            size.set(ulp_u,sizeU+sizeV);
        }

    }
    public static void main(String[] args)
    {
        DisjointSet ds = new DisjointSet(7);
        // ds.UnionByRank(1,2);
        // ds.UnionByRank(2,3);
        // ds.UnionByRank(4,5);
        // ds.UnionByRank(6,7);
        // ds.UnionByRank(5,6);
        
        // if(ds.findUPar(3) == ds.findUPar(7))
        // {
        //     System.out.println("same");
        // }
        // else
        // {
        //     System.out.println("not same");
        // }
        // ds.UnionByRank(3,7);
        // if(ds.findUPar(3) == ds.findUPar(7))
        // {
        //     System.out.println("same");
        // }
        // else
        // {
        //     System.out.println("not same");
        // }

        ds.UnionBySize(1,2);
        ds.UnionBySize(2,3);
        ds.UnionBySize(4,5);
        ds.UnionBySize(6,7);
        ds.UnionBySize(5,6);
        
        if(ds.findUPar(3) == ds.findUPar(7))
        {
            System.out.println("same");
        }
        else
        {
            System.out.println("not same");
        }
        ds.UnionBySize(3,7);
        if(ds.findUPar(3) == ds.findUPar(7))
        {
            System.out.println("same");
        }
        else
        {
            System.out.println("not same");
        }
    }
}