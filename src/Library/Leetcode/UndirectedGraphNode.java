package Library.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/30/15.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
