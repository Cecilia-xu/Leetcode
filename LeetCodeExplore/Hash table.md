# Introduction
Hash Table is a data structure which organizes data using hash functions in order to <strong>support quick insertion and search</strong>. There are two different kinds of hash tables: hash set and hash map.
- hash set : one of the implementations of a set data structure to store <strong>no repeated</strong> values.
- hash map : one of the implementations of a map data structure to store (key, value) pairs.
# The principle of hash table
The key idea of Hash Table is to use a hash function to map keys to buckets. To be more specific,
- When we insert a new key, the hash function will decide which bucket the key should be assigned and the key will be stored in the corresponding bucket;
- When we want to search for a key, the hash table will use the same hash function to find the corresponding bucket and search only in the specific bucket.
