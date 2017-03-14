<!DOCTYPE html>
<html lang="en">
<head>
    <title>RGB Table</title>
</head>
<body>
	<?php
		echo "<table><tbody><tr>
		<td>Red</td>
		<td>Green</td>
		<td>Blue</td>
		</tr>";
		for ($i = 51; $i <= 255; $i+=51) {
			echo "<tr>
			<td style=\"background-color: RGB({$i}, 0, 0)\"></td>
			<td style=\"background-color: RGB(0, {$i}, 0)\"></td>
			<td style=\"background-color: RGB(0, 0, {$i})\"></td>
			</tr>";
		}
		echo "</tbody></table>";
	?>
</body>
</html>