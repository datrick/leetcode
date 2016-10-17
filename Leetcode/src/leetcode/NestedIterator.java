package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private final Stack<ListIterator<NestedInteger>> stack;

    public NestedIterator(final List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
        hasNext();
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            final ListIterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) {
                stack.pop();
            } else {
                final NestedInteger ele = it.next();
                if (ele.isInteger()) {
                    it.previous();
                    break;
                } else {
                    stack.push(ele.getList().listIterator());
                }
            }
        }
        if (stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
