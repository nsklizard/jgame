<%@ page import="ru.nsk.lizard.game.common.GameProperties" %>
<%@ page import="ru.nsk.lizard.game.db.entities.Creature" %>
<%--
  Created by IntelliJ IDEA.
  User: dmitr_000
  Date: 19.05.2015
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game map</title>
</head>
<body>
<%
    Creature[][] map = (Creature[][]) request.getAttribute(GameProperties.MAP_ATTR);
    StringBuffer sb = new StringBuffer();
    for (int y = 0; y < GameProperties.WORLD_SIZE; y++) {
        sb.append("<tr>");
        for (int x = 0; x < GameProperties.WORLD_SIZE; x++) {
            sb.append("<td>").append(map[x][y].getCreatureId()).append("</td>");
        }
        sb.append("</tr>");
    }
%>
<table>
    <%=sb.toString()%>
</table>
</body>
</html>
