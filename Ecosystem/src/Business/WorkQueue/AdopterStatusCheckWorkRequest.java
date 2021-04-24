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
public class AdopterStatusCheckWorkRequest extends WorkRequest {
     private String bgcStatus;
     private String financeStatus;
     private String childCareStatus;

    public String getBgcStatus() {
        return bgcStatus;
    }

    public void setBgcStatus(String bgcStatus) {
        this.bgcStatus = bgcStatus;
    }

    public String getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(String financeStatus) {
        this.financeStatus = financeStatus;
    }

    public String getChildCareStatus() {
        return childCareStatus;
    }

    public void setChildCareStatus(String childCareStatus) {
        this.childCareStatus = childCareStatus;
    }
    
    
    
   
    
}
