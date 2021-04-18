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
    
    private String testResult;
    
    private boolean isAcquiredReq;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public boolean isIsAcquiredReq() {
        return isAcquiredReq;
    }

    public void setIsAcquiredReq(boolean isAcquiredReq) {
        this.isAcquiredReq = isAcquiredReq;
    }
    
   
    
}
