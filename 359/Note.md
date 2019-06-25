# Intuition 
This is a searching problem: a message exists in the last 10 timestamp? -> Key: relation: message & timestamp -> hashmap
# Algorithm
- create a hashmap to store message and timestamp in pairs
- If the message contains in the hashmap and it does not in the last 10 timestamp, put the new pair into the hashmap and return true
- Otherwise, return false
# Follow up
- Hashmap is not enough to store, how to optimize the solution?
# Intuition
- The most important information: last 10 pairs of message and timestamp -> focus on last 10 
- The information stored earlier will be cleaned earlier -> First in last out -> Queue
# Algorithm
- create a queue to store message & timestamp in pairs -> create a new static class with these 2 attributes
- clean useless space: if timestamp is not the last 10 (using timestamp) or queue is not empty
- check the target message contains in the queue or not -> no build in method in our own class -> create a hashset to store message
  - If contains: put message & timestamp in the queue and message in the hashset, return true
  - If not: return false
