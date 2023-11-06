package models

object CountingModel {
  
    private var ctr = 0

    def getNumber():Int = {
        return ctr
    }
    
    def incNumber():Int = {
        ctr += 1
        return ctr
    }

}
 