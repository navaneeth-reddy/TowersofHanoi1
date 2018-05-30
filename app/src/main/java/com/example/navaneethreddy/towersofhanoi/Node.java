package com.example.navaneethreddy.towersofhanoi;

public class Node
{
    private String payload;
    private Node nextNode;

    public Node(String payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public String getPayload()
    {
        return payload;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }
}
