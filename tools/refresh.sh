(echo -n -e "\
\$PGID,010101010101*06\r\n\
\$GPRMC,184332.07,A,1929.459,S,02410.381,E,74.00,16.78,210410,0.0,E,A*2B\r\n\
";) | nc -v localhost 5005