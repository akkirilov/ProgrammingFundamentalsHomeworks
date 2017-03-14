<!DOCTYPE html>
<html lang="en">
<head>
    <title>Fifty Shades of Grey</title>
	<meta charset="UTF-8">
	<style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
	<?php
		$gray = 0;
		for ($i = 0; $i < 5; $i++) {
			for ($j = 0; $j < 10; $j++) {
				echo "<div style=\"background-color: rgb({$gray}, {$gray}, {$gray});\"></div>";
				$gray+=5;
			}
			$gray++;
			echo "<br>";
		}
	?>
</body>
</html>