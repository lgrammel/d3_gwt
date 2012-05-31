// based on http://mbostock.github.com/d3/tutorial/bar-1.html
function d3_barchart(div, data) {
  
  var x = d3.scale.linear().domain([0, d3.max(data)]).range(["0px", "420px"]);
  
  var chart = d3.select(div).append("div").attr("class", "chart");
     
  chart.selectAll("div").data(data)
       .enter().append("div").style("width", x)
       .text(function(d) { return d; });
     
}