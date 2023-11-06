package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import models._

@Singleton
class Rapp @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
    def load = Action { implicit request => 
        Ok(views.html.reactversion())
    }
}