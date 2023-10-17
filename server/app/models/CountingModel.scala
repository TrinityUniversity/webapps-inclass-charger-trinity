package models

object CountingModel {
  
    private var ctr = 0

    def getNumber():Int = {
        return ctr
    }
    
    def incrementCtr():Unit = {
        ctr += 1
    }

}
 