object test{
  val f: String => String = { case "ping" => "pong"}

  f("ping")

  val f2: PartialFunction[String, String] = { case "ping" => "pong"}

  f2.isDefinedAt("ping")
  f2.isDefinedAt("abc")

}