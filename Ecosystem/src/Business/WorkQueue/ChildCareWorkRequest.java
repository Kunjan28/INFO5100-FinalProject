/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author snehaswaroop
 */
public class ChildCareWorkRequest extends WorkRequest {
    
    private String result;
    
    private boolean isAcquiredReq;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isIsAcquiredReq() {
        return isAcquiredReq;
    }

    public void setIsAcquiredReq(boolean isAcquiredReq) {
        this.isAcquiredReq = isAcquiredReq;
    }
    
   
    
}
