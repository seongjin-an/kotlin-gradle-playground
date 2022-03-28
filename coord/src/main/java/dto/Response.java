package dto;

import java.util.List;

public class Response {
    private Meta meta;
    private List<Document> documents;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Response{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
