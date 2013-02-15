/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import org.connectopensource.interopgui.view.Document;

/**
 * @author msw
 *
 */
public class DocumentInfo implements Document {
    
    private String documentId;
    private String documentType;
    private String comment;
    
    /**
     * @return the documentId
     */
    public String getDocumentId() {
        return documentId;
    }
    /**
     * @param documentId the documentId to set
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    /**
     * @return the document type
     */
    public String getDocumentType() {
        return documentType;
    }
    /**
     * @see documentType the documentType to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }
    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
